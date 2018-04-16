import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL;

public class ShaderProgram {

	private final int programID;
	
	private int vertexShaderID;
	private int fragmentShaderID;
	
	
	// constructor
	public ShaderProgram(String vertexFile, String fragmentFile) throws Exception {
		
		GL.createCapabilities();
		
		programID = glCreateProgram();
		
		
		if (programID == 0)
			throw new Exception("Could not create Shader Program");
		
		vertexShaderID = createShader(vertexFile, GL_VERTEX_SHADER);
		fragmentShaderID = createShader(fragmentFile, GL_FRAGMENT_SHADER);
		
		bindAllAttributes();
		link();
	}
	
	
	private int createShader(String file, int type) throws Exception {
		
		StringBuilder shaderSource = new StringBuilder();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
		}
		catch (IOException e) {
			System.err.println("Could not read file!");
			e.printStackTrace();
			System.exit(1);
		}
		
		int shaderID = glCreateShader(type);
		
		if (shaderID == 0)
			throw new Exception("Error creating Shader. Type: " + type);
		
		glShaderSource(shaderID, shaderSource);
		glCompileShader(shaderID);
		
		if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == 0)
			throw new Exception("Error compiling Shader code: " + glGetShaderInfoLog(shaderID, 1024));
		
		glAttachShader(programID, shaderID);
		
		return shaderID;
	}

	
	public void link() throws Exception {
        glLinkProgram(programID);
        if (glGetProgrami(programID, GL_LINK_STATUS) == 0) {
            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(programID, 1024));
        }

        if (vertexShaderID != 0) {
            glDetachShader(programID, vertexShaderID);
        }
        if (fragmentShaderID != 0) {
            glDetachShader(programID, fragmentShaderID);
        }

        glValidateProgram(programID);
        if (glGetProgrami(programID, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(programID, 1024));
        }
    }
	
	public void bind() {
		glUseProgram(programID);
	}
	
	public void unbind() {
		glUseProgram(0);
	}

	public void cleanUp() {
		
		unbind();
		
		if (programID != 0)
			glDeleteProgram(programID);
	}
	
	private void bindAllAttributes() {
		glBindAttribLocation(programID, 0, "position");
		glBindAttribLocation(programID, 1, "colours");
	}
}
