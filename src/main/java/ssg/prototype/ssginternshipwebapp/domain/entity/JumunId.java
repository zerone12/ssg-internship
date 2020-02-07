package ssg.prototype.ssginternshipwebapp.domain.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JumunId implements Serializable{
	
	@EqualsAndHashCode.Include
    @Id
	private Long customerId;
	
	@EqualsAndHashCode.Include
	@Id
	private int orderId;
	
	@Builder // 잘 모르겠음
    public JumunId(Long customerId, int orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }
}
