// Empty JS for your own code to be here

$("#classifyTier1").on("click", function(e) {
  e.preventDefault();
  alert('Clicked');
  $.ajax({type: "POST",
    url: "http://localhost:8080/monkeylearn",
    dataType: "json",
    contentType: "application/json;charset=utf-8",
    data: JSON.stringify
    ({
      text: $('#classifyTextArea').val()
    }),
    success:function(result) {
      $('#tagResult').html(result[0][0][0]['label']);
      $('#confidenceResult').html(result[0][0][0]['confidence']*100);
    },
    error:function(result) {
      alert('error');
    }
  });
});