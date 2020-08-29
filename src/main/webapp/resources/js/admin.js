$('.btn-add-doctor').click(function (){
    if(validateRegistrationDoctor()){
        return true;
    }else{
        return false;
    }
});

$('.btn-add-pharma').click(function (){
    if(validateRegistrationPharma()){
        return true;
    }else{
        return false;
    }
});

$('.btn-add-hosp').click(function (){
    if(validateRegistrationHosp()){
        return true;
    }else{
        return false;
    }
});

$('.btn-add-patient').click(function (){
    if(validateRegistrationPatient()){
        return true;
    }else{
        return false;
    }
});

function validateRegistrationDoctor() {
    var firstName = $("#doc-first-name");
    var lastName = $("#doc-last-name");
    var email = $("#doc-email");
    var username = $("#doc-username");
    var password = $(".doc-pass");
    var hospital = $(".hospital");

    var arr = [firstName, lastName, email, password, username, password, hospital];

    arr.forEach(el=>el.removeClass("is-invalid"))
    $(".doc-pass + .invalid-feedback").hide()
    $(".invalid-feedback + .invalid-feedback").hide();


   if(firstName.val()==""||lastName.val()==""||email.val()==""||password.val()==""||username.val()==""
       || hospital.val()==""){
       jQuery.each(arr,function(index,value){
           if(value.val() == ''){
               value.addClass("is-invalid")
               value.attr('placeholder', 'The field is empty')
           }
       })
       return false;
   }else if($('#doc-pass-1').val() != $('#doc-pass-2').val()) {
       $(".doc-pass").addClass("is-invalid");
       $(".doc-pass").attr('placeholder', 'Passwords do not match');
       $(".invalid-feedback + .invalid-feedback").show();
       return false;
   }else if(!email.val().match(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/)) {
        email.addClass("is-invalid")
       return false;
   }else if ($('#doc-pass-1').val().length < 8) {
       $('#doc-pass-1, #doc-pass-2').addClass("is-invalid");
       $(".doc-pass + .invalid-feedback").show();
       return false;
   }else {
       return true;
   }
}

function validateRegistrationPharma() {
    var firstName = $("#pharma-first-name");
    var lastName = $("#pharma-last-name");
    var email = $("#pharma-email");
    var username = $("#pharma-username");
    var password = $(".pharma-pass");
    var img = $("#pharma-img");

    var arr = [firstName, lastName, email, password, username, password, img];

    arr.forEach(el=>el.removeClass("is-invalid"))
    $(".pharma-pass + .invalid-feedback").hide()
    $(".pharma-pass + .invalid-feedback + .invalid-feedback").hide();


    if(firstName.val()==""||lastName.val()==""||email.val()==""||password.val()==""||username.val()==""
        || hospital.val()==""){
        jQuery.each(arr,function(index,value){
            if(value.val() == ''){
                value.addClass("is-invalid")
                value.attr('placeholder', 'The field is empty')
            }
        })
        return false;
    }else if($('#pharma-pass-1').val() != $('#pharma-pass-2').val()) {
        $(".pharma-pass").addClass("is-invalid");
        $(".pharma-pass").attr('placeholder', 'Passwords do not match');
        $(".pharma-pass + .invalid-feedback + .invalid-feedback").show();
        return false;
    }else if(!email.val().match(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/)) {
        email.addClass("is-invalid")
        return false;
    }else if ($('#pharma-pass-1').val().length < 8) {
        $('#pharma-pass-1, #pharma-pass-2').addClass("is-invalid");
        $(".pharma-pass + .invalid-feedback").show();
        return false;
    }else{
        return true;
    }
}

function validateRegistrationHosp() {
    var name = $("#hosp-name");

    name.removeClass("is-invalid")

    if(name.val()==""){
        name.addClass("is-invalid")
        name.attr('placeholder', 'The field is empty')
        return false;
    }else{
        return true;
    }
}

function validateRegistrationPatient() {
    var firstName = $("#patient-first-name");
    var lastName = $("#patient-last-name");

    var arr = [firstName, lastName];
    arr.forEach(el=>el.removeClass("is-invalid"))


    if(firstName.val()==""||lastName.val()==""){
        jQuery.each(arr,function(index,value){
            if(value.val() == ''){
                value.addClass("is-invalid")
                value.attr('placeholder', 'The field is empty')
            }
        })
        return false;
    }else{
        return true;
    }
}