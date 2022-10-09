package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.MailDto;
import com.ssafy.sowlmate.dto.request.UserFindPWRequestDto;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "sowlmate308@gmail.com";

    /**
     * DTO에 사용자가 원하는 내용과 제목을 작성
     */
    public MailDto createMailAndChangePassword(UserFindPWRequestDto requestDto) {
        String tempPassword = getTempPassword();
        log.debug(tempPassword);

        MailDto dto = new MailDto();
        dto.setAddress(requestDto.getUserId());
        dto.setTitle("[sOWLmate]" + requestDto.getUserName() + "님의 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요" + requestDto.getUserName() + "님,\n" + "귀하게서 요청하신 임시 비밀번호\n"
                + "수신을 위해 발송된 메일입니다.\n" + "\n" + "고객님의 임시 비밀번호는 " + tempPassword
        + " 입니다.\n" + "\n로그인 후에는 새로운 비밀번호로 변경하셔야 합니다.\n" + "감사합니다.");

        updatePassword(tempPassword, requestDto.getUserId());
        return dto;
    }

    /**
     * email로 발송된 임시비밀번호로 해당 유저의 password 변경
     */
    @Transactional
    public void updatePassword(String tempPassword, String userId) {
        User user = userRepository.findById(userId);
//        String tempPw = EncryptionUtils.encryptMD5(tempPassword);
//        user.setPassword(tempPw);
        user.setPassword(tempPassword);
        userRepository.save(user);
    }

    /**
     * 10자리의 랜덤난수를 생성
     */
    public String getTempPassword() {
        char[] charSet = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for(int i=0; i<10; i++){
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    public String sendEmail(MailDto mailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDto.getAddress());
        simpleMailMessage.setFrom(SendEmailService.FROM_ADDRESS);
        simpleMailMessage.setSubject(mailDto.getTitle());
        simpleMailMessage.setText(mailDto.getMessage());

        javaMailSender.send(simpleMailMessage);

        return "email 전송 완료 !";
    }

    public String sendIdCheckEmail(String userId) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(userId);
        simpleMailMessage.setFrom(FROM_ADDRESS);
        simpleMailMessage.setSubject("SOWLMATE Email(ID) Check");
        simpleMailMessage.setText(getAuthNumber());

        javaMailSender.send(simpleMailMessage);

        return simpleMailMessage.getText();
    }

    /**
     * 6자리 인증번호 생성
     */
    public String getAuthNumber() {
        char[] charSet = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        String str = "";

        int idx = 0;
        for(int i=0; i<6; i++){
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
}
