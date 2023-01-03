#version 400 core

in vec3 fragTextureCoord;

out vec4 fragColor;

uniform sampler2D textureSampler;

void main() {
    fragColor = texture(textureSampler, fragTextureCoord);
}