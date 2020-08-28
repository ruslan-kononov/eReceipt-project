$(document).ready(function() {
    $("input[name='languages']").change(function(){
        window.location.replace('?lang='+$(this).val());
    });
});
