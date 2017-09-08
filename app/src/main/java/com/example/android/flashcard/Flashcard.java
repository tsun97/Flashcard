package com.example.android.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tianyus2 on 4/13/2017.
 */

public class Flashcard implements Parcelable {
    private String term;
    private String definition;

    public Flashcard() {
        // needed by firebase to create objects
    }

    public Flashcard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flashcard flashcard = (Flashcard) o;

        if (term != null ? !term.equals(flashcard.term) : flashcard.term != null) return false;
        return definition != null ? definition.equals(flashcard.definition) : flashcard.definition == null;

    }

    @Override
    public int hashCode() {
        int result = term != null ? term.hashCode() : 0;
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.term);
        dest.writeString(this.definition);
    }

    protected Flashcard(Parcel in) {
        this.term = in.readString();
        this.definition = in.readString();
    }

    public static final Creator<Flashcard> CREATOR = new Creator<Flashcard>() {
        @Override
        public Flashcard createFromParcel(Parcel source) {
            return new Flashcard(source);
        }

        @Override
        public Flashcard[] newArray(int size) {
            return new Flashcard[size];
        }
    };
}
