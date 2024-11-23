$.noConflict();

function fetchCustomerInfo(button) {
    var flightID = button.getAttribute('data-flightid');
    var seatID = button.getAttribute('data-seatid');

    fetch(`/flight-booking/admin/seat-rest/customer-info/${flightID}/${seatID}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.status === 204 ? null : response.json();
        })
        .then(data => {
            var deleteButton = document.getElementById('deleteButton');
            // Kiểm tra nếu dữ liệu nhận được là rỗng
            if (data === null) {
                document.querySelector("#customerinfomodal .modal-body p").innerHTML = `
                    <strong>Ghế chưa được đặt</strong><br>
                `;

                if (deleteButton) {
                    deleteButton.disabled = true;
                    deleteButton.style.cursor = 'default';
                }
                return;
            }
             if (deleteButton) {
                deleteButton.disabled = false;
             }
            // Cập nhật thông tin khách hàng vào phần nội dung của modal
            document.querySelector("#customerinfomodal .modal-body p").innerHTML = `
                <strong>Mã khách hàng:</strong> ${data.userID}<br>
                <strong>Tên khách hàng:</strong> ${data.name}<br>
                <strong>Số điện thoại:</strong> ${data.phoneNum}
            `;
        })
        .catch(error => console.error('Lỗi khi lấy thông tin khách hàng:', error));
}

function deleteTicket(button) {
    var flightID = button.getAttribute('data-flightid');
    var seatNum = button.getAttribute('data-seatnum');
    var seatID = button.getAttribute('data-seatid')

    fetch(`/flight-booking/admin/ticket-rest/deleteticket/${flightID}/${seatNum}`, {
        method: 'DELETE'
    })
    .then(response => {

        var seatButton = document.querySelector(`#${seatID}`);
        seatButton.classList.remove('btn-secondary'); // Nếu ghế đang có màu xám
        seatButton.classList.add('btn-primary'); // Thay đổi thành màu cam hoặc một màu khác để biểu thị ghế trống

         $('#customerinfomodal').modal('hide');
    })

    .catch(error => console.error('Lỗi khi xóa vé: ', error))
}


jQuery(document).ready(function($) {

	"use strict";

	[].slice.call( document.querySelectorAll( 'select.cs-select' ) ).forEach( function(el) {
		new SelectFx(el);
	} );

	jQuery('.selectpicker').selectpicker;


	$('#menuToggle').on('click', function(event) {
		$('body').toggleClass('open');
	});

	$('.search-trigger').on('click', function(event) {
		event.preventDefault();
		event.stopPropagation();
		$('.search-trigger').parent('.header-left').addClass('open');
	});

	$('.search-close').on('click', function(event) {
		event.preventDefault();
		event.stopPropagation();
		$('.search-trigger').parent('.header-left').removeClass('open');
	});

	// $('.user-area> a').on('click', function(event) {
	// 	event.preventDefault();
	// 	event.stopPropagation();
	// 	$('.user-menu').parent().removeClass('open');
	// 	$('.user-menu').parent().toggleClass('open');
	// });

	 $(document).on('shown.bs.modal', function() {
            // Đảm bảo không có backdrop nào còn lại khi mở modal mới
            $('.modal-backdrop').remove();
//            $('body').addClass('modal-open');
        });


});