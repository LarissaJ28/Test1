#version 330

in vec3 passColours;

out vec4 fragColour;

void main(void) {
	
	fragColour = vec4(passColours, 1.0)*2.0;
}