package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.rpository.JpaAccountRepository;
import com.example.demo.lectureClass.fetchType.account.rpository.JpaAccountRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaAccountServiceImpl implements JpaAccountService {

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private JpaAccountRoleRepository accountRoleRepository;

    @Override
    public JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm) {
        final Optional<JpaAccount> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final JpaAccount account = accountRepository.save(requestForm.toJpaAccount());
        accountRoleRepository.save(requestForm.toJpaAccountRole(account));

        return account;
    }
}
