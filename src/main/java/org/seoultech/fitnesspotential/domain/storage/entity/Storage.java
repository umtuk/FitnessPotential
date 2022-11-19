package org.seoultech.fitnesspotential.domain.storage.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Storage {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 32)
    private String protocol;
    @Column(nullable = false, length = 32)
    private String scheme;
    @Column(nullable = false, length = 32)
    private String extension;

    @Column(nullable = false, length = 256)
    private String url;

    @Builder
    public Storage(Long id, String protocol, String scheme, String extension, String url) {
        this.id = id;
        this.protocol = protocol;
        this.scheme = scheme;
        this.extension = extension;
        this.url = url;
    }
}
