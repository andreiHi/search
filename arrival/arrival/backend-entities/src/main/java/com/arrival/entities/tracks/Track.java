package com.arrival.entities.tracks;

import com.arrival.entities.cars.Car;
import com.arrival.entities.templates.BaseEntityId;
import com.arrival.entities.templates.MetricsUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Track Entity
 *
 * @author Victor Karetko
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"name"}, callSuper = true)
@EqualsAndHashCode(of = {"name"}, callSuper = true)
@Table(indexes = {
        @Index(name = "idx_id_name", columnList = "id, name")
})
public class Track extends BaseEntityId {
    /**
     * Track name.
     */
    private String name;

    /**
     * Track description.
     */
    @Column(name = "description", length = 2000)
    private String description;

    /**
     * Track length.
     */
    @Embedded
    private MetricsUnit length;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "track_id")
    private List<Car> cars = new ArrayList<>();
}
