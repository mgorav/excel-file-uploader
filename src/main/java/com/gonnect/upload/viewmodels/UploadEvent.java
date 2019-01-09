package com.gonnect.upload.viewmodels;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UploadEvent {
   private String eventType = "progress";
   private Object state;

   public String getEventType() {
      return eventType;
   }

   public void setEventType(String eventType) {
      this.eventType = eventType;
   }

   public Object getState() {
      return state;
   }

   public void setState(Object state) {
      this.state = state;
   }
}
