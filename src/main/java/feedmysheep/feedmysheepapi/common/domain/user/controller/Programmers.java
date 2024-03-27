package feedmysheep.feedmysheepapi.common.domain.user.controller;


//정수 배열 numbers가 매개변수로 주어집니다.
//numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.

// 0 ≤ numbers의 원소 ≤ 1,000
// 1 ≤ numbers의 길이 ≤ 100
// 정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.

import java.util.Arrays;
import java.util.OptionalDouble;

class Solution {
    public double solution(int[] numbers) {

    OptionalDouble average = Arrays.stream(numbers).average();


      double answer = 0;
      return answer;
    }
  }
