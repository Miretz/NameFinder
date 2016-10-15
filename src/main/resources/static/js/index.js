$( document ).ready(function() {
    $(document).on("click", "#extractBtn", function(){
        var requestObj = new Object();
        requestObj.sentence = $("#sentence").val();
        $.ajax({
          url:"/names",
          type:"POST",
          data:JSON.stringify(requestObj),
          contentType:"application/json; charset=utf-8",
          dataType:"json",
          success: function(data){
            var list = $('<ul />');
            jQuery.each(data.extractedNames, function(index, value) {
                $('<li />', {text: value}).appendTo(list);
            });
            $("#result").html(list);
          }
        });
    });
 });