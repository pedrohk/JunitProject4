package org.service.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUserSuccess() {
        User newUser = new User(null, "Mariana Costa Ribeiro", "mariana.ribeiro89@gmail.com");
        User savedUser = new User("123", "Mariana Costa Ribeiro", "mariana.ribeiro89@gmail.com");


        when(userRepository.findByEmail("mariana.ribeiro89@gmail.com")).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User createdUser = userService.createUser(newUser);


        assertNotNull(createdUser);
        assertEquals("123", createdUser.getId());
        assertEquals("Mariana Costa Ribeiro", createdUser.getName());
        assertEquals("mariana.ribeiro89@gmail.com", createdUser.getEmail());

        verify(userRepository, times(1)).findByEmail("mariana.ribeiro89@gmail.com");
        verify(userRepository, times(1)).save(newUser);
        verifyNoMoreInteractions(userRepository);
    }
}
