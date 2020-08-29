$('.add-photo').click(function (){
    $(".custom-file-input").removeClass("is-invalid");
    var size = parseFloat($(".custom-file-input")[0].files[0].size / (1024*1024)).toFixed(2);
    if(size>1.99){
        $(".custom-file-input").addClass("is-invalid");
        return false;
    }
});

$(".custom-file-input").on('change',function(){
    var filePath = $(this).val().replace(/\\/g,'/').split("/");
    var fileName = filePath[filePath.length-1];
    $(this).next('.custom-file-label').html(fileName);
});
