package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service //@Component를 포함
public class MemberService {
    private final MemberRepository memberRepository ;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름 안된다.
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재합니다.";
        });
        */

        validateDuplicateMember(member); // 중복회원 조회
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(member1 -> {
                                    throw new IllegalStateException("이미 존재합니다");
                                });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
