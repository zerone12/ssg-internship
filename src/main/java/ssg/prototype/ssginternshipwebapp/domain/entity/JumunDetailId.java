package ssg.prototype.ssginternshipwebapp.domain.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JumunDetailId implements Serializable{
	
	@EqualsAndHashCode.Include
	@Id
	private int orderId;
	
	@EqualsAndHashCode.Include
    @Id
	private Long productId;
	
	@Builder // 잘 모르겠음
    public JumunDetailId(int orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
