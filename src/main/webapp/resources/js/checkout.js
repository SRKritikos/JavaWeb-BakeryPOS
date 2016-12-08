/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(window).ready(function () {
  var cartTotal = parseFloat($("#cartTotal").html());
  cartTotal = cartTotal.toFixed(2);
  var tax = parseFloat(cartTotal * .15).toFixed(2);
  var total = parseFloat(cartTotal) + parseFloat(tax);
  console.log(cartTotal, tax, total);
  total = parseFloat(total).toFixed(2);

  $("#cartTotal").html(cartTotal);
  $("#taxAddition").html(tax);
  $("#totalPrice").html("<strong>$" + total + "</strong>");

  $("#toConfirmBtn").click(function () {
    $(".active").removeClass("active");
    $(".order-nav li:last-child").addClass("active");
  });

  $("#backToBilling").click(function () {
    $(".active").removeClass("active");
    $(".order-nav li:first-child").addClass("active");
  });
});
