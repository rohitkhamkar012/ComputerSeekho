package com.example.serviceImpl;

import com.example.dto.StudentDTO;
import com.example.entity.BatchMaster;
import com.example.entity.CourseMaster;
import com.example.entity.StudentMaster;
import com.example.repository.BatchMasterRepository;
import com.example.repository.CourseMasterRepository;
import com.example.repository.StudentRepository;
import com.example.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseMasterRepository courseRepository;
    private final BatchMasterRepository batchRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseMasterRepository courseRepository,
                              BatchMasterRepository batchRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO dto) {

        if (studentRepository.existsByStudentUsername(dto.getStudentUsername())) {
            throw new RuntimeException("Username already exists");
        }

        StudentMaster student = new StudentMaster();
        mapDtoToEntity(dto, student);

        return mapEntityToDto(studentRepository.save(student));
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        StudentMaster student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapEntityToDto(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO dto) {
        StudentMaster student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        mapDtoToEntity(dto, student);
        return mapEntityToDto(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    // ===== Mapping =====
    private void mapDtoToEntity(StudentDTO dto, StudentMaster student) {

        student.setStudentName(dto.getStudentName());
        student.setStudentAddress(dto.getStudentAddress());
        student.setStudentGender(dto.getStudentGender());
        student.setStudentDob(dto.getStudentDob());
        student.setStudentQualification(dto.getStudentQualification());
        student.setStudentMobile(dto.getStudentMobile());
        student.setCourseFee(dto.getCourseFee());
        student.setStudentUsername(dto.getStudentUsername());

        if (dto.getCourseId() != null) {
            CourseMaster course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));
            student.setCourse(course);
        }

        if (dto.getBatchId() != null) {
            BatchMaster batch = batchRepository.findById(dto.getBatchId())
                    .orElseThrow(() -> new RuntimeException("Batch not found"));
            student.setBatch(batch);
        }
    }

    private StudentDTO mapEntityToDto(StudentMaster student) {

        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setStudentName(student.getStudentName());
        dto.setStudentAddress(student.getStudentAddress());
        dto.setStudentGender(student.getStudentGender());
        dto.setStudentDob(student.getStudentDob());
        dto.setStudentQualification(student.getStudentQualification());
        dto.setStudentMobile(student.getStudentMobile());
        dto.setCourseFee(student.getCourseFee());
        dto.setStudentUsername(student.getStudentUsername());

        if (student.getCourse() != null)
            dto.setCourseId(student.getCourse().getCourseId());

        if (student.getBatch() != null)
            dto.setBatchId(student.getBatch().getBatchId());

        return dto;
    }
}
