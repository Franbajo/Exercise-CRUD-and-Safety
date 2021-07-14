/**
 * 
 */
function eliminarAlumno(id){
	console.log(id);
	swal({
		title: "¿Está seguro de eliminar?",
		text: "Una vez eliminado no se prodrá restablecer!",
		icon: "warning",
		  buttons: true,
		dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			$.ajax({
				url:"/eliminarAlumno/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		swal("Poof! Registroeliminado!", {
		      icon: "success",
		    }).then((ok)=>{
			if(ok){
				location.href="/listarAlumno";
			}
		    });
		  } 
		});

}