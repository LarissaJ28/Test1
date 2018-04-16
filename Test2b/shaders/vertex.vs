#version 330

in vec3 position;
in vec3 colours;

out vec3 passColours;

void main(void) {

	gl_Position = vec4(position, 1.0);
	passColours = colours;
}