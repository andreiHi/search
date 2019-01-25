package com.arrival.entities.cars;

import com.arrival.entities.enums.AiScheme;
import com.arrival.entities.enums.Transmission;
import com.arrival.entities.templates.BaseEntityId;
import com.arrival.entities.templates.MetricsUnit;
import com.arrival.entities.tracks.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Car Entity
 * @author Victor Karetko
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"code"}, callSuper = true)
@EqualsAndHashCode(of = {"code"}, callSuper = true)
@Table(indexes = {
        @Index(name = "idx_id_code", columnList = "id, code")
})
public class Car extends BaseEntityId {

    /**
     * Track name.
     */
    private String code;

    /**
     * Track name.
     */
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    /**
     * Ai of car.
     */
    @Enumerated(EnumType.STRING)
    private AiScheme ai;

    /**
     * Track length.
     */
    @Embedded
    private MetricsUnit maxSpeed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Track track;
}
