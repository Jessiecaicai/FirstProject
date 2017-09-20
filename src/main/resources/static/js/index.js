function addData(){
//	alert( $("#name").val());
    $.ajax({
            url: '/addBringInfo',
            type: 'POST',
            dataType: 'json',
        //data: $('#form1').serialize(),
           /* data: {
            	"name": $("#name").val(),
            	"type":$("#type").val(),
            	id:0
            },*/
            data: JSON.stringify({
            	"name":$("#name").val(),
            	"people":$("#people").val(),
            	"time":$("#time").val(),
            	"title":$("#title").val(),
            	"type":$("#type").val(),
            	"location":$("#location").val(),
            	"worktime":$("#worktime").val(),
            	"workplace":$("#workplace").val(),
            	"pay":$("#pay").val(),
            	"deadline":$("#deadline").val(),
            	"sex":$("#sex").val(),
            	"grade":$("#grade").val(),
            	"place":$("#place").val(),
            	"need":$("#need").val()
            }),
            	
            traditional : false,
		    cache : false,
		    async: false,
		    contentType : 'application/json; charset=UTF-8',
            // bedforeSend: $("#table1").html('加载中...请稍后！'),
            // success: $('form').submit(function () {
            //     alert($(this).serialize());
            //     return false;
            // }),
            success: function (result) {
                // console.log(databack);
                // alert("成功!");
                if(result.success){
                    alert("提交成功！")
                }
                // alert($(this).serialize());
            },

            error: function () {
                console.log("提交失败,请重试!");
                alert("失败了");
            }
        })
    }
        





