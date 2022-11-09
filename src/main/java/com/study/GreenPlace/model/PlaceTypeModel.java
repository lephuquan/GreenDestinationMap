package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.study.GreenPlace.entity.Criterias;
import com.study.GreenPlace.entity.Places;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class PlaceTypeModel {

    private Short placetypeid;
    private String type;
    private Collection<PlaceModel> placeModelCollection;
    private Collection<CriteriasModel> criteriasModelCollection;
}
