


	 function check() {
		var username = $("#username").val()
	
		console.log(username);
		$.ajax({
			type:"POST",
			url:"/auth/user/check", //auth
			data:username,
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){

			if(resp.data !== 0) {
				alert("이 아이디는 사용할 수 없습니다.");
				location.href="redirect:/";
			} else {
				alert("이 아이디는 사용할 수 있습니다.");
				location.href="redirect:/";
			}

		}).fail(function(error){
			alert("아이디를 입력해주세요");
		});
	}



/*
		function searchuserid() {
			console.log(1)
//			var userid = document.getElementById("userid");
	//		var phonenumber = document.getElementById("phonenumber");

			// < 1
			
			if(userid.value == "") {
				alert("이름을 입력해주세요")
				userid.focus();
				return fales;
			}
			if(phonenumber.value.length != 11) {
				alert("핸드폰번호를 정확하게 입력해주세요")
				phonenumber.focus();
				return fales;
			}
			 
			 
			 
			var userid = $("#userid").val();
			var phonenumber = $("#phonenumber").val();
			
			$.ajax({
				type="POST",
				url:"/auth/user/search",
				data:{userid,phonenumber},
				contentType:"application/json; charset=utf-8",
				dataType:"json" 
			}).done(function(resp){
				
				console.log(1);
				
				if(resp.data !== 0) {
					alert("존재하는");
					location.href="redirect:/";
				} else {
					alert("존재하지 않는 회원입니다.");
					location.href="redirect:/";
				}
	
		})
		
	}


*/




let index={
	init: function(){
		$("#btn-save").on("click",()=>{
		var userid = document.getElementById("userid");
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		var pwdcheck = document.getElementById("pwdcheck");
		var birthday = document.getElementById("birthday");
		var phonenumber = document.getElementById("phonenumber");
		var email = document.getElementById("email");
		var remember_check = document.getElementById("remember_check");
		var remember_check2 = document.getElementById("remember_check2");
		
		var reg = /^[0-9]+/g; 
				
		if (userid.value == "") {
			alert("이름을 입력하세요.");
			userid.focus();
			return false;
		};
		
		if (username.value == "") { 
			alert("아이디를 입력하세요.");
			username.focus(); 
			return false; 
		};
		
		if (password.value == "") {
			alert("비밀번호를 입력하세요.");
			password.focus();
			return false;
		};
		
		//var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
		
//		if (!pwdCheck.test(password.value)) {
//			alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
//			pwd.focus();
//			return false;
//		};
	

		if (pwdcheck.value !== password.value) {
			alert("비밀번호가 일치하지 않습니다..");
			pwdcheck.focus();
			return false;
		};

		if (birthday.value == "") {
			alert("생년월일을 입력하세요.");
			birthday.focus();
			return false;
		};
		
		
		if (!reg.test(phonenumber.value)) {
			alert("전화번호를 입력하세요.");
			phonenumber.focus();
			return false;
		}
		
		if (email.value == "") {
			alert("이메일 주소를 입력하세요.");
			email.focus();
			return false;
		}
		
		if (!remember_check.checked) { 
			alert("약관 동의를 체크하세요.");
			remember_check.focus();
			return false;
		}
		
		if (!remember_check2.checked) { 
			alert("약관 동의를 체크하세요.");
			remember_check2.focus();
			return false;
		}
		this.save();
		//document.join_form.submit(); 
		//document.joinForm.submit(); 
			

		});
		
		$("#btn-update").on("click",()=>{
			//화살표 함수사용 이유: this를 바인딩하기 위해 사용
			this.update();
		});



		$("#btn-out").on("click",()=>{
			
			var chk1 = document.querySelector("#checkList").checked;
			
			if(!chk1) {
				alert("약관에 동의해 주세요");
				return false;
				
			} else {
				
				let check = confirm("정말로 탈퇴하시겠습니까");
				
				if(check) {
					alert("탈퇴가 완료되었습니다.");
					this.out();
				} else {
					alert("최소되었습니다.");
				}
				
			}

		});
		

},
	
	
	save: function(){
		
		//var join  = joinform_check();
		
		//alert('user의 save함수 호출됨');
		let data={
			username: $("#username").val(),
			userid: $("#userid").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			birthday: $("#birthday").val(),
			phonenumber: $("#phonenumber").val()
		};
		console.log(data); 
		//console.log(JSON.stringfy(data)) json 오브젝트
		//ajax호출시 디폴트가 비동기 호출
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
		$.ajax({ 
			//회원가입 수행 요청 
			//(100초라 가정한다면 도중에 done이나 fail 실행 )
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data), //http body 데이터
			contentType:"application/json; charset=utf-8",
			dataType:"json" //자동으로 변환해주기 때문에 생략 가능
			//응답의 결과가 문자열이 아닌 json으로 변환
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			location.href="/auth/loginForm";
			//응답이 정상
			
		}).fail(function(error){
			alert("아이디를 다시 확인해주세요.");
			location.href="/";
		//location.href="/auth/joinForm";

			//응답이 비정상
		});
		//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청!!
	},
	
	update: function(){
		let data={
			id: $("#id").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			birthday: $("#birthday").val(),
			phonenumber: $("#phonenumber").val()
		};
		console.log(id);
		console.log(email);
		$.ajax({ 
			type:"PUT",
			url:"/auth/user",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			location.href="/user/mypage";
			
			//응답이 정상
		}).fail(function(error){
			alert("다시 수정해주세요.");
			location.href="/";
			
			//응답이 비정상
		});
	},


	out: function(){
		//alert('user의 save함수 호출됨');
		var id=$("#id").val();

		$.ajax({
			type:"DELETE",
			url:"/api/user/out/"+id,
			
			dataType:"json" //자동으로 변환해주기 때문에 생략 가능
			//응답의 결과가 문자열이 아닌 json으로 변환
		}).done(function(resp){
			location.href="/logout";
			//응답이 정상
		}).fail(function(error){
			alert(JSON.stringify(error));
			//응답이 비정상
		});
	},


	

}
index.init();





