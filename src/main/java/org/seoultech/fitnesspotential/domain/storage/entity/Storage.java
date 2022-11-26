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

    @Column(nullable = false, length = 256)
    private String url;


    @Builder
    public Storage(Long id, String protocol, String scheme, String extension, String url) {
        this.id = id;
        this.url = url;
    }

    public static class StorageBuilder {

        private Long id;
        private String url;

        public StorageBuilder storage(Storage storage) {
            this.id = storage.id;
            this.url = storage.url;
            return this;
        }
    }
}
