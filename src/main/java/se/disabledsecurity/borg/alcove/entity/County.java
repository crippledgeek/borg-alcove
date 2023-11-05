package se.disabledsecurity.borg.alcove.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;


import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "County")
@Builder
@Table(name = "county")
@NoArgsConstructor
@AllArgsConstructor
public class County {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "code", nullable = false, unique = true)
	private int code;

	@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private Set<Municipality> municipalities = new LinkedHashSet<>();

	@Version
	@Column(name = "version")
	private Integer version;

	public void setMunicipalities(Set<Municipality> municipalities) {
		this.municipalities = municipalities;
	}
}