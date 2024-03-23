package feedmysheep.feedmysheepapi.common.domain.user.dto;

import feedmysheep.feedmysheepapi.common.models.UserEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginUserReqDto {

  private int id;

  @NotNull(message = "email는 필수 값입니다.")
  private String email;


  @NotNull(message = "password는 필수 값입니다.")
  private String password;


  // entity -> dto로 변환하기
  public static LoginUserReqDto toUserReqDto(UserEntity userEntity) {
    LoginUserReqDto userReqDto = new LoginUserReqDto();
    userReqDto.setEmail(userEntity.getEmail());
    userReqDto.setPassword(userEntity.getPassword());

//    userReqDto.setId(userEntity.getId());
//    userReqDto.setName(userEntity.getName());
//    userReqDto.setPhone(userEntity.getPhone());
    return userReqDto;
  }
}