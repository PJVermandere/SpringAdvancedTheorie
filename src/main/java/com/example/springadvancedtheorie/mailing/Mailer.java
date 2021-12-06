package com.example.springadvancedtheorie.mailing;

import com.example.springadvancedtheorie.domain.Lid;
import org.springframework.stereotype.Component;

public interface Mailer{
    void bevestigingsMail(Lid lid, String ledenUrl);
}
