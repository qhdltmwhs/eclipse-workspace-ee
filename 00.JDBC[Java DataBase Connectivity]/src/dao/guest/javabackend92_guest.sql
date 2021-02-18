insert into guest values(guest_no_seq.nextval , '김경호', sysdate, 'guard@naver.com', 'http://', '방명록 사용법', '방명록처럼 사용하시면 됩니다');

select * from guest;
select * from guest where guest_no=3;
select  guest_no, guest_name, guest_date, guest_email, guest_homepage, guest_title,guest_content from guest;

update guest set guest_name='김경자', guest_email='kkk@daum.net', guest_homepage='http://수정', guest_title='난감하네', guest_content='정말난감하네'
where guest_no = 3;

delete guest where guest_no=1;