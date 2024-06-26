package se.disabledsecurity.borg.alcove.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "municipalities")
@Entity
@Table(name = "municipality")
public class Municipality {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "code", nullable = false)
	private int code;

	@Version
	@Column(name = "version")
	private Integer version;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ?
								   ((HibernateProxy) o)
										   .getHibernateLazyInitializer()
										   .getPersistentClass() :
								   o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
									  ((HibernateProxy) this)
											  .getHibernateLazyInitializer()
											  .getPersistentClass() :
									  this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Municipality that = (Municipality) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ?
			   ((HibernateProxy) this)
					   .getHibernateLazyInitializer()
					   .getPersistentClass()
					   .hashCode() :
			   getClass().hashCode();
	}
}