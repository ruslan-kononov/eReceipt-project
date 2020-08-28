$('.btn-prescribe').click(function (){
    if(validatePrescription()){
        return true;
    }else{
        return false;
    }
});


function validatePrescription() {
    var patient = $(".patient");
    var medicine = $(".medicine");
    var prescrText = $(".prescrText");

    var arr = [patient, medicine];

    arr.forEach(el=>el.removeClass("is-invalid"))

    if(patient.val()==""||medicine.val()==""){
        jQuery.each(arr,function(index,value){
            if(value.val() == ''){
                value.addClass("is-invalid")
            }
        })
        return false;
    }else if(prescrText.val().length > 510) {
        $(".prescrText").addClass("is-invalid");
        return false;
    }else{
        return true;
    }
}

$(document).ready(function() {
    $("input[name='languages']").change(function(){
        window.location.replace('?lang='+$(this).val());
    });
});
