package com.minh.demo.mapper;

import org.springframework.stereotype.Component;

@Component
public class UserMappper {
    public User toEntity(UserDto dto ){
        User entity = new User();
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setAge(dto.getAge());
        entity.setRole(dto.getRole());
        entity.setAddress(dto.getAddress());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;

    }


    public UserReponseDto toDto(User entity){
        UserReponseDto dto = new UserReponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        dto.setAddress(entity.getAddress());
        dto.setRole(entity.getRole());

        return dto;

    }

    public List <UserReponseDto> toDtoList(List<User> entities) {
        if (entities == null || entities.isEmpty()){
            return new ArrayList<>();
        }
        return entities.stream()
                .map(User user -> this.Dto(user))
                .collect(Collectors.tolist());

    }
}
