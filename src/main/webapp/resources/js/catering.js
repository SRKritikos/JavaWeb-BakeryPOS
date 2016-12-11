/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(window).ready(function () {
  $(".products-wrapper").css({"display": "none"});
  showHideBtnHandler();
  makeCheckoutBtnDisabled();
});

function showHideBtnHandler() {
  $(".showProducts").click(function (e) {
    var btnVal = $(this).val();
    var html = $(this).html();
    if (btnVal === "none") {
      btnVal = "block";
      html = "Hide";
    } else {
      btnVal = "none";
      html = "Show";
    }
    console.log(btnVal);
    $(this).val(btnVal);
    $(this).html(html);
    console.log($(this).parent("div").siblings(".products-wrapper"));
    //WTB .grandParent();
    $(this).parent("div").parent("div").next(".products-wrapper").css({"display": btnVal});
  });
 
}

function makeCheckoutBtnDisabled() {
  var cartTotal = parseInt($("#cartTotal").html());
  if (!cartTotal > 0) {
    $("#checkoutForm\\:checkoutBtn").addClass("disabled");
  } else {
    $("#checkoutForm\\:checkoutBtn").removeClass("disabled");
  }
}

function orderUpdate(data) {
  console.log(data);
  if (data.status === "success") {
    makeCheckoutBtnDisabled();
    showHideBtnHandler();
  }
}