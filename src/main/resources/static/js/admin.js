/**
 * 
 */
 let admin={
	enroll:function(){
		let data={
			username:$("#adminname").val(),
			userid:$("#userid").val(),
			password:$("#adminpwd").val(),
			email:$("#adminemail").val(),
			phonenumber:$("#adminphone").val(),
			birthday:$("#adminbirthdate").val()
		};
		$.ajax({
			url:"/auth/joinmanager",
			type:"POST",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("admin 등록완료");
			location.href="/auth/usermanage"
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

let ordermanage={
	defaultorder:function(){
		let orderid = $("#orderid").val()
		$.ajax({
			url:"/auth/defaultorder/"+orderid,
			type:"PUT",
			dataType:"json"
		}).done(function(resp){
			alert("주문정보를 기본값으로 변경했습니다.");
			location.href="/auth/manager"
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	changeorder:function(){
			let orderid = $("#orderid").val()
		$.ajax({
			url:"/auth/changeorder/"+orderid,
			type:"PUT",
			dataType:"json"
		}).done(function(resp){
			alert("주문정보를 교환신청으로 변경했습니다.");
			location.href="/auth/manager"
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	cancelorder:function(){
			let orderid = $("#orderid").val()
		$.ajax({
			url:"/auth/cancelorder/"+orderid,
			type:"PUT",
			dataType:"json"
		}).done(function(resp){
			alert("주문정보를 취소신청으로 변경했습니다.");
			location.href="/auth/manager"
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}