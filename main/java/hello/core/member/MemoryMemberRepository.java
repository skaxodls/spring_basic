package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store=new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
