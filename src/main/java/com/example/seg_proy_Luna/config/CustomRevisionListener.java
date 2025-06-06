package com.example.seg_proy_Luna.config;

import com.example.seg_proy_Luna.entities.audi.Revision;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) { final Revision revision = (Revision) revisionEntity;
    }
}
