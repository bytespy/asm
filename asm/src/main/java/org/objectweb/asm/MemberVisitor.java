package org.objectweb.asm;

/**
 * A visitor to visit a Java class, field, method or record component.
 *
 * @author Eric Bruneton
 */
abstract class MemberVisitor {

  /**
   * Visits an annotation of the member.
   *
   * @param descriptor the class descriptor of the annotation class.
   * @param visible {@literal true} if the annotation is visible at runtime.
   * @return a visitor to visit the annotation values, or {@literal null} if this visitor is not
   *     interested in visiting this annotation.
   */
  abstract AnnotationVisitor visitAnnotation(final String descriptor, final boolean visible);

  /**
   * Visits an annotation on the type of the member.
   *
   * @param typeRef a reference to the annotated type.
   * @param typePath the path to the annotated type argument, wildcard bound, array element type, or
   *     static inner type within 'typeRef'. May be {@literal null} if the annotation targets
   *     'typeRef' as a whole.
   * @param descriptor the class descriptor of the annotation class.
   * @param visible {@literal true} if the annotation is visible at runtime.
   * @return a visitor to visit the annotation values, or {@literal null} if this visitor is not
   *     interested in visiting this annotation.
   */
  abstract AnnotationVisitor visitTypeAnnotation(
      final int typeRef, final TypePath typePath, final String descriptor, final boolean visible);

  /**
   * Visits a non standard attribute of the member.
   *
   * @param attribute an attribute.
   */
  abstract void visitAttribute(final Attribute attribute);

  /** Visits the end of the member. */
  abstract void visitEnd();
}
