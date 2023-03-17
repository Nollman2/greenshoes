let basket1={
	input:function(){
		let productid=$("#cart_productid").val()
		data={
			productsize:$("#productsize").val(),
			amount:1
		}

 $.ajax({
	type:'POST',
	url:'/api/basket/'+productid,
	data:JSON.stringify(data),
	contentType:"application/json; charset=utf-8",
    dataType:"json"
    
}).done(function(){
	alert("장바구니등록 완료");
	location.href="/auth/basket";
}).fail(function(error){
	alert(JSON.stringify(error));
	
});

},
purchase: function() {
         var itemId = $("input[name='buy']:checked");
         if (itemId[0] != undefined) {
            var itemIds = "";
            var amounts = "";
            var check = 0;
            itemId.each(function(index) {
               let id = $(this).val();
               quantitys = $("#p_num" + id).val();

               if ($("#p_num" + id).val() == "" || $("#p_num" + id).val() == null || $("#p_num" + id).val() < 1) {
                  check = 1;
               }
            });
            if (check != 1) {
               itemId.each(function(index) {
                  if (itemIds == "") {
                     itemIds = $(this).val();
                     let id = $(this).val();
                     amounts = $("#p_num" + id).val();
                  } else {
                     itemIds += "," + $(this).val();
                     let id = $(this).val();
                     amounts += "," + $("#p_num" + id).val();
                  }
               });
               let data = {
                  itemIds: itemIds,
                  amounts: amounts,
               };
               $.ajax({
                  type: "POST",
                  url: "/api/order",
                  data: JSON.stringify(data),
                  contentType: "application/json; charset=utf-8",
                  dataType: "json"
               }).done(function(resp) {
                  alert("구매페이지 이동.");
                  location.href = "/api/order/"+itemIds;
               }).fail(function(error) {
                  alert(JSON.stringify(error));
               });
            } else {
               alert("상품갯수를 다시 설정해주세요.");
            }
         } else {
            alert("상품을 선택해주세요.");
         }

}
}
