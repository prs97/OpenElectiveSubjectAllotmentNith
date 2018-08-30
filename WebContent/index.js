$(document).ready(function () {
//semester system
  $("#sem, #branch").change(function () {
    var Sem = $("#sem").val();
    var Branch = $("#branch").val();
      if (Sem==1) {
        $(".oes").css({"display":"none"});
        $("#ecefiveth, #civilfiveth").css({"display":"none"});
        if (Branch=="ECE") {
          $("#ecefst").css({"display":"block"});
          $("#civilfst").css({"display":"none"});
        }else if (Branch=="CIVIL") {
          $("#civilfst").css({"display":"block"});
          $("#ecefst").css({"display":"none"});
        }
      }else if (Sem==5) {
        $(".oes").css({"display":"block"});
        $("#ecefst, #civilfst").css({"display":"none"});
        if (Branch=="ECE") {
          $("#ecefiveth").css({"display":"block"});
          $("#civilfiveth").css({"display":"none"});
        }else if (Branch=="CIVIL") {
          $("#civilfiveth").css({"display":"block"});
          $("#ecefiveth").css({"display":"none"});
        }
      }
  });


  //open elective system
  $("#branch").change(function () {
    var Branch = $("#branch").val();
      if (Branch=="CIVIL") {
        $(".cpm").css({"display":"none"});
        $(".fuzzy, .qe, .msd, .ds").css({"display":"block"});
      }else if (Branch=="EEE") {
        $(".fuzzy").css({"display":"none"});
        $(".cpm, .qe, .msd, .ds").css({"display":"block"});
      }else if (Branch=="MED") {
        $(".qe").css({"display":"none"});
        $(".cpm, .fuzzy, .msd, .ds").css({"display":"block"});
      }else if (Branch=="ECE") {
        $(".msd").css({"display":"none"});
        $(".cpm, .fuzzy, .qe, .ds").css({"display":"block"});
      }else if(Branch=="CSE") {
        $(".ds").css({"display":"none"});
        $(".cpm, .fuzzy, .qe, .ds").css({"display":"block"});
      }
  });
})
