function addToCart(bookId)
{
	document.addForm.action="../cart/add/"+bookId;	
	document.addForm.submit();	
	alert("도서가 장바구니에 추가되었습니다!");
	
}

function clearCart() {
	document.clearForm.submit();	
	 window.location.reload();
}

function removeFromCart( action) {
	document.removeForm.action = action;
	document.removeForm.submit();	
	window.location.reload();
}


function deleteConfirm(id){
   if (confirm("삭제 합니다!!") == true) location.href ="./delete?id="+id; 
   else  return;
}
