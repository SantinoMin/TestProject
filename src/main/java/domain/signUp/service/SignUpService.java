package domain.signUp.service;

import domain.signUp.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

  private SignUpRepository signUpRepository;

  @Autowired
  public SignUpService(SignUpRepository signUpRepository) {
    this.signUpRepository = signUpRepository;
  }

  // MyRepository를 사용하는 다른 메소드들...


}