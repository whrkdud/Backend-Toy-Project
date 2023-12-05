// 테이블이랑 연결하는거

package com.example.project1128.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
    @Id
    String memberId;
    String memberPw;
    String memberName;
}
