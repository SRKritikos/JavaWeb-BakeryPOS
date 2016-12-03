/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    console.log("Hello")
   $(".writeReviewBtn").click(function(){
       var name = $(this).closest(".product").find(".product-info p:first-child").html();
       var id = $(this).closest(".product").attr("id");
       console.log(id, name);
       $("#product-review-name").html("Review for item: " + name);
       $("#modalProductId").val(id);
       $("#write-review-modal").modal();
   });
});