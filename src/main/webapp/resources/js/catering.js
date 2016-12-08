/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(window).ready(function () {
//   var cartTotal = parseFloat($("#cartTotal").html());
//   cartTotal = cartTotal.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
//   $("#cartTotal").html("$"+cartTotal);
  $(".products-wrapper").css({"display": "none"});
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

//   $(".addProductBtn").click(function(e) {
//      var $id =  $(this).closest(".products").attr("id");  
//      $.ajax({
//        url : "AddProductToOrder",
//        type: 'POST',
//        data : { 
//                 "id" : $id
//               } 
//      }).done(function(data) {
//          console.log(data);
//          updateUserProductInformation(data);
//      }).fail(function(error){
//          console.log("error");
//          console.log(error);
//      }); 
//   });

//   $(".removeProductBtn").click(function(e){
//       var numProducts = parseInt($(this).closest(".products").find(".numProducts").html());
//       if (numProducts > 0) {
//            var $id =  $(this).closest(".products").attr("id");
//            $.ajax({
//                url : "RemoveProductFromOrder",
//                type : "POST",
//                data : { "id" : $id }
//            }).done(function(data){ 
//                console.log(data);
//                updateUserProductInformation(data);
//            }).fail(function(error){
//                console.log(error);
//            });
//        }
//    });
});

function updateUserProductInformation(data) {
  var cartTotal = data.cartTotal
  cartTotal = cartTotal.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
  console.log(cartTotal);
  $("#" + data.id).find(".numProducts")
          .html(data.orderProductQty);
  $("#cartTotal").html("$" + cartTotal);
}