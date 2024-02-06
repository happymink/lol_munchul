package com.service.lol_munchul.domain.agenda.service;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.domain.agenda.repository.AgendaRepository;
import com.service.lol_munchul.domain.agenda.dto.AgendaCreateRequest;
import com.service.lol_munchul.domain.member.entity.Member;
import com.service.lol_munchul.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AgendaServiceTest {

    @InjectMocks
    private AgendaService agendaService;

    @Mock
    private AgendaRepository agendaRepository;

    @Mock
    private MemberRepository memberRepository;

    @Nested
    @DisplayName("안건 생성")
    class CreateAgenda {

        @Test
        @DisplayName("안건을 생성할 수 있다.")
        void 안건_생성() {
            // Given
            given(agendaRepository.save(any(Agenda.class))).willReturn(Agenda.builder().agendaCreateRequest(
                    new AgendaCreateRequest("title","content", "videoUrl")).build());
            given(memberRepository.save((any(Member.class)))).willReturn(Member.builder().build());
            // When
            var actual = agendaService.createAgenda(new AgendaCreateRequest(
                    "title", "content", "videoUrl"
            ));
            System.out.println(actual);
            // Then
            then(agendaRepository).should().save(any());
            //assertNotNull(actual);
        }
    }

}