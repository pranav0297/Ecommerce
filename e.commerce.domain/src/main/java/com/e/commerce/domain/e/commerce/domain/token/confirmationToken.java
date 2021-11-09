package com.e.commerce.domain.e.commerce.domain.token;

import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class confirmationToken {

//    @SequenceGenerator(
//            name = "confirmation_token_sequence",
//            sequenceName = "confirmation_token_sequence",
//            allocationSize = 1
//    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Seller seller;

    public confirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Seller seller) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.seller=seller;
    }

}
