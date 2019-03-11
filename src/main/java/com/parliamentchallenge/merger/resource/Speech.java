package com.parliamentchallenge.merger.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.awt.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Speech {
    private UUID uniqueID;

    public String getIid() {
        return iid;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    private String iid;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private String affiliation = "";
    private String email = "";
    private String constituency = "";
    private URL img;
    private String subject = "";
    private URL speechURL;
    private String name;

    public UUID getUniqueID() {
        return uniqueID;
    }

    public Date getDate() {
        return date;
    }



    public String getConstituency() {
        return constituency;
    }

    public URL getImg() {
        return img;
    }

    public String getSubject() {
        return subject;
    }

    public URL getSpeechURL() {
        return speechURL;
    }

    /*  A unique ID, representing the speech itself    <- generera?
    Date of speech <- första
    The name of the speaker, and only the name <- talare, första
    Political affiliation <- första
    The official e-mail address <-  andra
    Constituency <- andra
    A decent sized image that could be used in a web site listing <- andra
    The debate subject <- kammaraktivitet? första
    A link to the speech (HATEOAS style) <- protokoll_url_www första
    */
    public static class SpeechBuilder {
        private UUID uniqueID;
        private Date date;
        private String affiliation;
        private String email;
        private String constituency;
        private URL img;
        private String subject;
        private URL speechURL;
        private String iid;
        private String name;

        public SpeechBuilder () {
            this.uniqueID = UUID.randomUUID();
        }

        public SpeechBuilder withDate (String date) throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            this.date = simpleDateFormat.parse(date);
            return this;
        }



        public SpeechBuilder withAffiliation(String affiliation) {
            this.affiliation = affiliation;
            return this;

        }

        public SpeechBuilder withEmail(String email) {
            this.email = email;
            return this;

        }

        public SpeechBuilder withIID(String iid) {
            this.iid = iid;
            return this;
        }

        public SpeechBuilder withConstituency(String constituency) {
            this.constituency = constituency;
            return this;

        }

        public SpeechBuilder withImg(URL img) {
            this.img = img;
            return this;

        }

        public SpeechBuilder withSubject(String subject) {
            this.subject = subject;
            return this;

        }

        public SpeechBuilder withSpeechURL(URL speechURL) {
            this.speechURL = speechURL;
            return this;
        }

        public SpeechBuilder withName(String name) {
            this.name = name;
            return this;
        }


        public Speech build() {
            Speech speech = new Speech();
            speech.date = this.date;
            speech.affiliation = this.affiliation;
            speech.constituency = this.constituency;
            speech.date = this.date;
            speech.email = this.email;
            speech.img = this.img;
            speech.speechURL = this.speechURL;
            speech.uniqueID = this.uniqueID;
            speech.subject = this.subject;
            speech.name = this.name;
            speech.iid = this.iid;
            return speech;
        }
    }


    private Speech () {

        // use builder
    }

    @Override
    public String toString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "[" + this.iid + "]: " + this.name + ", " + this.email + ", " + this.affiliation;
    }
}
