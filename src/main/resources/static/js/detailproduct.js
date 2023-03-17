function detailproduct(e){
	let id = e.querySelector(".id").val();
	location.href="/auth/product/"+id;
}