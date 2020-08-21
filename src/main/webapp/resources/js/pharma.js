$('.btn-check-prescription').click(function (){
    validatePrescriptionCheck();
});

var prescriptionFound = null;

function validatePrescriptionCheck() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    var prescrCode = $(".prescrCode");

    prescrCode.removeClass("is-invalid")
    $(".prescrCode + .invalid-feedback").hide()
    $(".invalid-feedback + .invalid-feedback").hide();

    if(prescrCode.val()==""){
        prescrCode.addClass("is-invalid")
        $(".prescrCode + .invalid-feedback").show()
        return false;
    }else if(prescrCode.val().length < 8 ||prescrCode.val().length > 8) {
        $(".invalid-feedback + .invalid-feedback").show();
        return false;
    }else{
        var code = {prescriptionNumber:prescrCode.val()}
        jQuery.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                url: "/pharma/checkPrescription",
                data: JSON.stringify(code),
                dataType: 'json',
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                },
                success: function(data) {
                    if(data!="not found"){
                        prescriptionFound = data;
                    }else{
                        var content = '';
                        content+= '<h3>There is no prescription with such a code.</h3>'
                        $('.table-prescription').html(content);
                    }
                }
            }
        ).done(function (){
            var content = '';
            content+=
                '<table class="table">'+
                    '<thead>'+
                        '<tr>'+
                            '<th scope="col">Patient</th>'+
                            '<th scope="col">Medicine</th>'+
                            '<th scope="col">Doctor</th>'+
                            '<th scope="col">Date</th>'+
                            '<th scope="col">Issued</th>'+
                            '<th scope="col"></th>'+
                        '</tr>'+
                    '</thead>'+
                    '<tbody>'+
                        '<tr>'+
                            '<th class="align-middle">'+prescriptionFound.patientName+'</th>'+
                            '<td class="align-middle">'+prescriptionFound.medicine+'</td>'+
                            '<td class="align-middle">'+prescriptionFound.doctorName+'</td>'+
                            '<td class="align-middle">'+prescriptionFound.date+'</td>'+
                            '<td class="align-middle">'+prescriptionFound.status+'</td>'+
                            '<td class="align-middle"><button class="btn btn-outline-primary btn-form btn-issue" data-code-id="'+prescriptionFound.prescrId+'" type="button">Issue</button></td>'+
                        '</tr>'+
                    '</tbody>'+
                '</table>'
            $('.table-prescription').html(content);
        }).done(function (){
            $(".btn-issue").click(function () {
                var code = {prescriptionNumber:$(this).data("code-id")}
                jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        type: "POST",
                        url: "/pharma/issuePrescription",
                        data: JSON.stringify(code),
                        dataType: 'json',
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader(header, token);
                        },
                        success: function(data) {
                            if(data=='success'){
                                var content = '';
                                content+= '<h3>The medicine can be issued.</h3>'
                                $('.table-prescription').html(content);
                            }else{
                                var content = '';
                                content+= '<h3>The medicine has been already issued.</h3>'
                                $('.table-prescription').html(content);
                            }
                        }
                    }
                )
            });
        });
    }
}

