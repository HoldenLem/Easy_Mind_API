package easy.mind.com.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.io.Serializable;
import java.time.Instant;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @CreationTimestamp
    protected Instant createdAt;

    @UpdateTimestamp
    protected Instant modifiedAt;

}
